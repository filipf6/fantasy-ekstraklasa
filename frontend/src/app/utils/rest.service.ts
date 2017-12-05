import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Http, Headers} from "@angular/http";
import {AuthenticationService} from "../auth/auth.service";

@Injectable()
export class RestService {

  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + this.authenticationService.getToken()
  });

  constructor(private http: Http, private authenticationService: AuthenticationService) {
  }

  get(url: string): Observable<any> {
    //let finalUrl = 'api/'+url;
    //const header=new Headers();
    // header.append('Authorization','Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkdWRhQGdvdi5wbCIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUxMDAxMjU2MTUwNCwiZXhwIjoxNTEwNjE3MzYxfQ.2OF_fKpyroNVAe2SyQiqIq3sJY7O5rFJwyMbG3FY_9VEgXbFXQ5b_0EX-jdZnUcdR7QpYpsP93LYPq28z0SC3g');
    return this.http.get('api/'+url, {headers: this.headers}).map(response=>response.json());
  }

  post(url: string, params: any, headers: Headers): Observable<any> {
    return this.http.post('api/'+url,params, headers).map(response=>response.json());
  }

}
