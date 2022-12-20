import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DataResult} from '../model/data-result';
import {Talent} from '../model/talent';


const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class ShoeService {

  constructor(private httpClient: HttpClient) {
  }

  showListTalent(name: string, curPage: number, numberRecord: number) {
    console.log(curPage, numberRecord);
    return this.httpClient.get<DataResult<Talent>>(
      API_URL + '/talent' + '?page=' + (curPage - 1) + '&size=' + numberRecord + '&nameS=' + name);
  }
}
