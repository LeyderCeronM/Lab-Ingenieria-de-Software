package com.piedrazul.Infrastructure.config;

import javax.swing.SwingUtilities;

import com.piedrazul.Domain.core.events.ClsClinicEventBus;
import com.piedrazul.Infrastructure.repository.IDatabaseConnection;
import com.piedrazul.Infrastructure.repository.IAppointmentRepository;
import com.piedrazul.Infrastructure.repository.IUserRepository;
import com.piedrazul.Infrastructure.repository.impl.ClsAppointmentRepository;
import com.piedrazul.Infrastructure.repository.impl.ClsSQLiteUserRepository;
import com.piedrazul.Infrastructure.repository.impl.SQLiteConnection;
import com.piedrazul.Presentation.controller.LoginController;
import com.piedrazul.Presentation.controller.UserController;
import com.piedrazul.Presentation.views.LoginView;
import com.piedrazul.services.IAppointmentService;
import com.piedrazul.services.IUserService;
import com.piedrazul.services.impl.ClsAppointmentServiceImpl;
import com.piedrazul.services.impl.ClsUserServiceImpl;

public class AppInitializer {

    public void start() {
        // Inicialización de infraestructura
        IDatabaseConnection databaseConnection = new SQLiteConnection();
        IUserRepository userRepository = new ClsSQLiteUserRepository(databaseConnection);
        IAppointmentRepository appointmentRepository = new ClsAppointmentRepository(databaseConnection);
        ClsClinicEventBus eventBus = new ClsClinicEventBus();

        // Inicialización de servicios
        IUserService userService = new ClsUserServiceImpl(userRepository, eventBus);
        IAppointmentService appointmentService = new ClsAppointmentServiceImpl(appointmentRepository);

        // Inicialización de controladores
        UserController userController = new UserController(userService);

        // Inicialización de UI
        initUI(userService, userController, appointmentService);
    }

    private void initUI(IUserService userService, UserController userController, IAppointmentService appointmentService) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            new LoginController(loginView, userService, userController, appointmentService);
            loginView.setVisible(true);
        });
    }
}
