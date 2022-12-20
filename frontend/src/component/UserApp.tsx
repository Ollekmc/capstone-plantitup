import AddUser from "./AddUser";
import useUsers from "../hooks/UseUsers";
import UserGallery from "./UserGallery";

export default function UserApp(){
    const {users, addUser, deleteUser} = useUsers();

    return(
        <div>
            <h2>User</h2>
            <AddUser addUser={addUser}/>
            <UserGallery users={users} removeUser={deleteUser}/>
        </div>
    )
}