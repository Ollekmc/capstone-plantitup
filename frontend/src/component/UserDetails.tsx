import {useParams} from "react-router-dom";
import useUser from "../hooks/UseUser";

function UserDetails(){
    const parameters = useParams();

    const id: string | undefined = parameters.id;

    const {user} = useUser(id);

    if (!user) {
        return (
            <p>No users to display</p>
        )
    }

    return (
        <div>
            <p>User Übersicht</p>
            {!user && <p>No users to display</p>}
            {<div>
                <p>{user.name}</p>
                <p>{user.id}</p>
                <p>{user.email}</p>
            </div>}
        </div>

    )
}
export default UserDetails;