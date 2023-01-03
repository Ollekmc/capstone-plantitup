import {useEffect, useState} from "react";
import {NewUser, User} from "../model/User";
import axios from "axios";

export default  function useUsers() {
    const [users, setUsers] = useState<User[]>([])

    useEffect(()=> {
        getUsers()
        //eslint-disable-next-line
    },[])

    function getUsers(){
        axios.get("api/users")
            .then(response => {
                setUsers(response.data)
            })
            .catch(console.error)
    }


    function addUser(newUser: NewUser) {
        return axios.post("/api/users", newUser)
            .then(response => response.data)
            .then((savedUser) => setUsers(prevState => [...prevState, savedUser]))
            .catch(console.error)
    }

    function deleteUser(id: string){
        axios.delete("/api/users/{id}")
            .then(() => {
            setUsers(prevState => {
                return prevState.filter((user) => user.id !==id
                )
            })
        })
    }
    return {users, addUser, deleteUser}
}