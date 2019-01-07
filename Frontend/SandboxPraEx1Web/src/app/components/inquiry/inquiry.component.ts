import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';

import { Inquiry } from '../../models/inquiry';
import { InquiryService } from '../../services/inquiry.service';

@Component({
  selector: 'app-inquiry',
  templateUrl: './inquiry.component.html',
  styleUrls: ['./inquiry.component.scss']
})
export class InquiryComponent implements OnInit {

  displayedColumns: string[] = ['no', 'firstName', 'lastName', 'email', 'comments', 'totalNumber', 'createdDate'];
  dataSource: MatTableDataSource<Inquiry>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  tNumber: number;

  constructor(
    private inquiryService: InquiryService
  ) {}

  ngOnInit() {      
    this.refreshInquiryList();
  }

  refreshInquiryList() {
    this.inquiryService.getInquiryAll().subscribe((res) => {
      console.log('Refreshed Inquiry List'); 
      this.tNumber = 45;
      this.inquiryService.inquiries = res as Inquiry[];
      this.dataSource = new MatTableDataSource(this.inquiryService.inquiries);
      this.dataSource.paginator = this.paginator;      
    });
  }

}

