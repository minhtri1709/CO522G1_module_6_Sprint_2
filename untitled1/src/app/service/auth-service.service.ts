import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const URL_API = `${environment.url}`;

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  httpOptions: any;
  isLoggedIn = false;

  constructor(private http: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
    };
  }

  login(obj: { username: string; password: string }): Observable<any> {
    console.log(obj);
    return this.http.post(
      URL_API + '/login',
      {
        username: obj.username,
        password: obj.password,
      },
      this.httpOptions
    );
  }
}
