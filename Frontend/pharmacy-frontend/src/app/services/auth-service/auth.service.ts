import { HttpClient, HttpResponseBase } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Login } from 'src/app/model/login/login';
import { AuthenticatedUser } from 'src/app/model/security/AuthenticatedUser';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject: BehaviorSubject<AuthenticatedUser>;
  public currentUser: Observable<AuthenticatedUser>;

  constructor(private http: HttpClient, private router: Router) {
    this.currentUserSubject = new BehaviorSubject<AuthenticatedUser>(this.getCurrentUser())
    this.currentUser = this.currentUserSubject.asObservable();
  }

  login(loginDto: Login) {
    return this.http.post<AuthenticatedUser>(`${environment.baseUrl}/${environment.auth}/${environment.login}`, loginDto)
    .pipe(map(response=> {
      console.log("KURCINAAAAAAA");
      localStorage.setItem('currentUser', JSON.stringify(response));
      this.currentUserSubject.next(response);
      return response;
    }));
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
  
  public get currentUserValue() : AuthenticatedUser {
    return this.currentUserSubject.value;
  }

  private getCurrentUser() : AuthenticatedUser {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  public getUserValue() : AuthenticatedUser {
    return this.currentUserSubject.getValue();
  }
}
