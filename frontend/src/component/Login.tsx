import {useState} from "react";

export type LoginProps = {
    username:string,
    password:string
}
export default function Login(props: LoginProps){
    const [username,setUsername] = useState("");
    const [password, setPassword] = useState("");

    function onUsernameChange (){
        return setUsername(username)
    }
    function onPasswordChange (){
        return setPassword(password)
    }

    return (
        <div>
        <input type={"text"} value={username} placeholder={"Username"} onChange={onUsernameChange}/>
        <input type={"password"} value={password} placeholder={"Password"}/>
        </div>
    )
}