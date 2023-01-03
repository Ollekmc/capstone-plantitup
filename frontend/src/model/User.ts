import {Plant} from "./Plant";

export type User = {
    id: string;
    name: string;
    email: string;
    password: string;
    plantlist: Plant[];
}

export type NewUser = {
    name: string;
    email: string;
    password: string;
}