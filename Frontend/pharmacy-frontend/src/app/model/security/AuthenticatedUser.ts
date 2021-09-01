import { Role } from "../user/role";

export class AuthenticatedUser {
    public userId: number;
    public role: Role;
    public expiresIn: number;
    public token: String;

    constructor(userId: number, role: Role, expiresIn: number, token: String) {
        this.userId = userId;
        this.role = role;
        this.expiresIn = expiresIn;
        this.token = token;
    }
}