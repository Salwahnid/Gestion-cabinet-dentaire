import { Routes } from '@angular/router';

import { LoginComponent } from '../../pagesToDelete/login/login.component';
import { RegisterComponent } from '../../pagesToDelete/register/register.component';

export const AuthLayoutRoutes: Routes = [
    { path: 'login',          component: LoginComponent },
    { path: 'register',       component: RegisterComponent }
];
