import Login from "./Login";

export type headBarProps = {
    username: string,
    password: string
}

export default function HeadBar(props: headBarProps){
    return(
        <div>
            <div>
                <button>Login</button>
                <Login username={props.username} password={props.password}/>
            </div>
            <div>
                <button>SignUp</button>

            </div>
        </div>
            )
}