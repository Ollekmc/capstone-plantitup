import {NewUser} from "../model/User";
import {ChangeEvent, useState} from "react";

type AddUserProps = {
    addUser: (newUser: NewUser) => Promise<any>;
}

export default function AddUser(props: AddUserProps){
    const [name, setName] = useState<string>("");
    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");
  //  const [plantList, setPlantList] = useState<Plant[]>([]);

    function onNameChange(event: ChangeEvent<HTMLInputElement>) {
        setName(event.target.value)
    }
    function onEmailChange(event: ChangeEvent<HTMLInputElement>) {
        setEmail(event.target.value)
    }
    function onPasswordChange(event: ChangeEvent<HTMLInputElement>) {
        setPassword(event.target.value)
    }
   // function onPlantListChange(event: ChangeEvent<HTMLInputElement>) {
  //      setPlantList(event.target.list)
  //  }
    function onSave() {
        props.addUser({name:name,email:email,password:password})
            .then(() => {
                setName("");
                setEmail("");
                setPassword("");
            })
    }
    return (
        <div>
            <input type={"text"} placeholder={"Name"} value={name} onChange={onNameChange}/>
            <input type={"text"} placeholder={"Email"} value={email} onChange={onEmailChange}/>
            <input type={"text"} placeholder={"Password"} value={password} onChange={onPasswordChange}/>
            <br/>
            <button onClick={onSave}>Speichern</button>
            <br/>
        </div>
    )
}