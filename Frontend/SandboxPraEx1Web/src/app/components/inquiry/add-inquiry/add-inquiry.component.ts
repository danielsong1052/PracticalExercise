import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {ErrorStateMatcher} from '@angular/material/core';

import { InquiryService } from '../../../services/inquiry.service';
import { CommonService } from '../../../services/common.service';

import { Inquiry } from '../../../models/inquiry';

import * as $ from 'jquery';

declare var M: any;

@Component({
  selector: 'app-add-inquiry',
  templateUrl: './add-inquiry.component.html',
  styleUrls: ['./add-inquiry.component.scss']
})
export class AddInquiryComponent implements OnInit {
  
  isValidFormSubmitted = false;  
  emailPattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
  inquiryForm: FormGroup;

  inquiry : Inquiry = new Inquiry();
  createdDate: any;  

  constructor(
    private router: Router,
    private inquiryService: InquiryService,
    private commonService: CommonService,
    private formBuilder: FormBuilder
  ) {
    this.inquiryForm = this.formBuilder.group({
      'email': ['', [Validators.required, Validators.pattern(this.emailPattern)]]
    });
  }

  ngOnInit() { 
    $(function() {
      $('#comments').keyup(function (e){
          var comments = $(this).val();
          $(this).height(((comments.split('\n').length + 1) * 1.5) + 'em');
          $('#counter').html(comments.length + '/150');
      });
      $('#comments').keyup();
    });
  }

  onSubmit(inquiryValues){  
    if(inquiryValues.invalid){            
      return;
    }
    
    this.isValidFormSubmitted = true;
    this.createdDate = new Date();
    this.inquiry.createdDate = this.commonService.getSimpleTodayDate(this.createdDate); 
    this.addInquiry(this.inquiry);
    this.inquiryForm.reset();
  } 

  addInquiry(inquiry : Inquiry){
    this.inquiryService.addInquiry(this.inquiry).subscribe( 
      res => {                
        M.toast({html: 'Registered Successfully', classes: 'rounded'});        
        this.router.navigate(['/inquiry']);
      }, err => {
        M.toast({html: 'Failed to register', classes: 'rounded'});
        this.router.navigate(['/addInquiry']);
      }    
    );
  }

}
