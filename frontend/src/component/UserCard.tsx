import {User} from "../model/User";
import UserDetails from "./UserDetails";

type UserCardProps = {
    user: User;
    deleteUser: (id: string) => void;
}

export default function UserCard(props: UserCardProps){

    return(
        <div className={"user-card"}>
            <p>{props.user.name}</p>
            <p>{props.user.id}</p>
            <p>{props.user.email}</p>
            <UserDetails/>
        </div>
    )

}
//TODO details, addplants, delete, edit