import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { AuthService } from "../services/auth-service/auth.service";

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
   
    
    errorMessages = [500, 400, 402, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 422, 425, 42, 428, 329, 431, 451]

    constructor(private router: Router, private authService: AuthService) {}
    
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        return next.handle(req).pipe(catchError(err => {
            if([401, 403].indexOf(err.status) !== -1) {
                this.authService.logout;
                throwError(err);
            } 
            else {
                const error = err.error.message || err.statusText;
                return throwError(error);
            }

            if (this.errorMessages.indexOf(err.status) !== -1) {
                const error = err.error.message || err.statusText;
                return throwError(error);

            }

            return throwError(err);
           
        }))
    }


}