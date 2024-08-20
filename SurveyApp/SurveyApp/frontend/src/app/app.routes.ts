import { Routes } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { DataViewComponent } from './dataview/dataview.component';
import { WorkerExampleComponent } from './worker-example/worker-example.component';

export const routes: Routes = [
    { path: 'home', component: UsersComponent },
    { path: 'users', component: UsersComponent },
    { path: 'add-user', component: EditUserComponent },
    { path: 'edit-user/:id', component: EditUserComponent },
    { path: 'refresh', component: DataViewComponent },
    { path: 'worker-example', component: WorkerExampleComponent },
];
