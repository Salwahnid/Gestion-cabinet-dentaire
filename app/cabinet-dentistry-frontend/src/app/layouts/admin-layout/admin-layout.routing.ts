import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pagesToDelete/dashboard/dashboard.component';
import { IconsComponent } from '../../pagesToDelete/icons/icons.component';
import { MapsComponent } from '../../pagesToDelete/maps/maps.component';
import { UserProfileComponent } from '../../pagesToDelete/user-profile/user-profile.component';
import { TablesComponent } from '../../pagesToDelete/tables/tables.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'tables',         component: TablesComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent }
];
