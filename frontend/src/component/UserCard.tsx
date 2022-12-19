import {User} from "../model/User";

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
        </div>
    )

}
//TODO details, addplants, delete, edit