import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InquiryComponent } from './components/inquiry/inquiry.component';
import { AddInquiryComponent } from './components/inquiry/add-inquiry/add-inquiry.component';
import { DetailInquiryComponent } from './components/inquiry/detail-inquiry/detail-inquiry.component';
import { MainComponent } from './components/main/main.component';

const appRoutes : Routes = [     
    { path:'main' , component: MainComponent }, 
    { path:'inquiry' , component: InquiryComponent },   
    { path:'addInquiry' , component: AddInquiryComponent}, 
    { path:'detailInquiry/:id' , component: DetailInquiryComponent}, 
    { path:'**' , redirectTo: 'main', pathMatch: 'full' }    
]

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}