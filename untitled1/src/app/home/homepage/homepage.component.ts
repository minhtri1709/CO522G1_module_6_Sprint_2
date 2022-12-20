import { Component, OnInit } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {Talent} from '../../model/talent';
import {ShoeService} from '../../service/shoe.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
 page = 1;
 name = '';
 pageSize = 4;
 talentList$: Observable<Talent[]>;


  constructor(private shoeService: ShoeService) { }

  ngOnInit(): void {
    this.getAllList();
  }

  getAllList(): void {
    this.shoeService.showListTalent(this.name, this.page, this.pageSize).subscribe(value => {
      this.talentList$ = new BehaviorSubject<Talent[]>(value.content);
    }, error => {
      console.log(error);
      }
    );
  }

}
