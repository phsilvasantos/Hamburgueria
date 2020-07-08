import { NotFoundComponent } from './errors/not-found/not-found.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LanchesComponent } from './Modules/lanches/lanches.component';
import { LanchesDetalhesComponent } from './Modules/lanches-detalhes/lanches-detalhes.component';
import { TodosLanchesComponent } from './Modules/todos-lanches/todos-lanches.component';

const routes: Routes = [
    {
        path: 'lanches',
        component: LanchesComponent
    },
    {
        path: 'lanches/:id',
        component: LanchesDetalhesComponent
    },
    {
        path: 'todosLanches',
        component: TodosLanchesComponent
    },
    {
        path: '**',
        component: NotFoundComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}