import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "../services/auth-service/auth.service";


@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private authService: AuthService) {

    }
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        
        const currentUser = this.authService.currentUserValue;

        if(currentUser) {
            if(route.data.roles && route.data.roles.indexOf(currentUser.role) === -1) {
                this.router.navigate['/dermatologists']
                return false;
            }

            return true;
        }

        this.router.navigate['/login'];
        return false;
       
    }
    
}