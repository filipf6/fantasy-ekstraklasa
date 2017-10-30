import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class RestService {

  constructor(private http: Http) {
  }

  get(url: string): Observable<any> {
    //let finalUrl = 'api/'+url;
    return this.http.get('api/'+url).map(response=>response.json());
  }

}
