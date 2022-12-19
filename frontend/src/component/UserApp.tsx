import AddUser from "./AddUser";

export default function UserApp(){
    const {users, addUser, deleteUser} = useUsers();

    return(
        <div>
            <h2>User</h2>
            <AddUser addUser={addUser}/>
        </div>
    )
}