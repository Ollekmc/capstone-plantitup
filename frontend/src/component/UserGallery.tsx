import {ChangeEvent, useState} from "react";
import {User} from "../model/User";
import UserCard from "./UserCard";

type UserGalleryProps= {
    users: User[];
    removeUser: (id: string) => void;
}

export default function UserGallery(props: UserGalleryProps){

    const [searchText, setSearchText] = useState<string>("");

    const filteredUsers: User[] = props.users.filter(user => user.name.toLowerCase().includes(searchText.toLowerCase()))

    function onChangeOfSearch(event: ChangeEvent<HTMLInputElement>){
        setSearchText(event.target.value)
    }

    return (
        <div>
            <input placeholder={"Search User(erstmal nur)"} value={searchText} onChange={onChangeOfSearch}/>
            <div>
                {filteredUsers.map(user => <UserCard user={user} key={user.id} deleteUser={props.removeUser}/>)}
            </div>
        </div>
    )
}