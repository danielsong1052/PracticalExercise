import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app.routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule, MatInputModule, MatSelectModule, MatNativeDateModule, MatCardModule,
  MatExpansionModule, MatIconModule, MatAutocompleteModule, MatDatepickerModule, MatTableModule, MatPaginatorModule 
} from '@angular/material';

// Components
import { AppComponent } from './app.component';
import { InquiryComponent } from './components/inquiry/inquiry.component';
import { AddInquiryComponent } from './components/inquiry/add-inquiry/add-inquiry.component';
import { DetailInquiryComponent } from './components/inquiry/detail-inquiry/detail-inquiry.component';
import { MainComponent } from './components/main/main.component';
import { NavbarComponent } from './components/navbar/navbar.component';

// Services
import { CommonService } from './services/common.service';
import { InquiryService } from './services/inquiry.service';
import { RecommendationService } from './services/recommendation.service';
import { CategoryService } from './services/category.service';

@NgModule({
  declarations: [
    AppComponent,
    InquiryComponent,
    AddInquiryComponent,
    DetailInquiryComponent,
    MainComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule, 
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    MatExpansionModule,
    MatIconModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatPaginatorModule 
  ],
  providers: [
    CommonService,
    InquiryService,
    RecommendationService,
    CategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
