import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Http, Headers} from "@angular/http";
import {AuthenticationService} from "../auth/auth.service";

@Injectable()
export class RestService {

  constructor(private http: Http, private authenticationService: AuthenticationService) {
  }

  get(url: string): Observable<any> {
    return this.http.get('api/'+url, {headers: this.buildHeader()})
      .map(response=>response.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  post(url: string, body: any): Observable<any> {
    return this.http.post('api/'+url,body, {headers: this.buildHeader()})
      .map(response=>response.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  buildHeader(): Headers {
    return new Headers({'Authorization': 'Bearer ' + this.authenticationService.getToken()});
  }

}
