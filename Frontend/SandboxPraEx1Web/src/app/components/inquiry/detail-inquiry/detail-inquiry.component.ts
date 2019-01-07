import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Inquiry } from '../../../models/inquiry';
import { Recommendation } from '../../../models/recommendation';
import { Category } from '../../../models/category';
import { InquiryService } from '../../../services/inquiry.service';
import { RecommendationService } from '../../../services/recommendation.service';
import { CommonService } from '../../../services/common.service';
import { CategoryService } from '../../../services/category.service';

@Component({
  selector: 'app-detail-inquiry',
  templateUrl: './detail-inquiry.component.html',
  styleUrls: ['./detail-inquiry.component.scss']
})
export class DetailInquiryComponent implements OnInit {

  inquiry: any;
  id: number;
  categories: Category[];
  recommendations: Recommendation[];
  recommendation: Recommendation = new Recommendation();
  createdDate: any;
  panelOpenState = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private inquiryService: InquiryService,
    private recommendationService: RecommendationService,
    private commonService: CommonService,
    private categoryService: CategoryService
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    
    // Detail Inquiry    
    this.detailInquiry(this.id);

    // Get Recommendations
    this.getRecommendations(this.id);

    // Get Categories
    this.getCategories();
  }

  detailInquiry(id:number){
    this.inquiryService.getInquiry(this.id).subscribe(
      res =>{
        console.log('Detail Inquiry Successfully.'); 
        this.inquiryService.inquiry = res as Inquiry;
      },
      err => {
        console.log('Detail Inquiry Error.'); 
      }
    ); 
  }

  getCategories(){
    this.categoryService.getAllCatetories().subscribe(
      res => {
          this.categories = res as Category[];
          console.log('Get Category Successfully.');   
      },
      err => {
        console.log('Get Category Error.'); 
      }
    );
  }

  getRecommendations(id:number){
    this.recommendationService.getRecommendationAll(this.id).subscribe(
      res => {
        console.log('Get Recommendation Successfully.');         
        this.recommendations = res as Recommendation[];                  
      },
      err => {
        console.log('Get Recommendation Error.'); 
      }
    ) 
  }

  onSubmitRecommendation(){ 
    this.recommendation.inquiryId = this.id;
    this.createdDate = new Date();
    this.recommendation.createdDate = this.commonService.getSimpleTodayDate(this.createdDate);    

    this.recommendationService.addRecommendation(this.recommendation).subscribe(
      res => {
        console.log('Add Recommendation Successfully.');
        this.getRecommendations(this.id);
        this.recommendation.category = " "; 
        this.recommendation.comments = " ";       
      },
      err => {
        console.log('Add Recommendation Error.'); 
      }
    )
  }
}
