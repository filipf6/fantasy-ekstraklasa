import {Injectable} from "@angular/core";
import {Http, Headers, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {User} from "../models/user.model";

@Injectable()
export class AuthenticationService {
  private authUrl = 'api/auth';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }

  login(email: string, password: string): Observable<boolean> {
    ///console.log('username: '+email+', password: '+password);
    // return this.restService
    //   .post(this.authUrl,JSON.stringify({email: email, password: password}), this.headers)
    //   .map((response: Response) => {
    //
    //   })
    return this.http.post(this.authUrl+'/signIn', JSON.stringify({email: email, password: password}), {headers: this.headers})
      .map((response: Response) => {
        let token = response.json() && response.json().token;
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({ email: email, token: token }));
          return true;
        } else {
          return false;
        }
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  register(user: User): Observable<any> {
    return this.http
      .post(this.authUrl+'/signUp', {name: user.name, surname: user.surname, email: user.email, password: user.password, enabled: true}, {headers: this.headers})
      //.map(response => response.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getToken(): String {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    // clear token remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    console.log('current User: '+localStorage.getItem('currentUser'));
    var token: String = this.getToken();
    return token && token.length > 0;
  }

}
