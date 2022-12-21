import React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import UserApp from "./component/UserApp";
import HeadBar from "./component/HeadBar";

function App() {
    const username = "Username";
    const password = "Password";

  return (

    <div className="App">
        <title>PlantApp</title>
      <BrowserRouter>
        <Routes>
            <Route path={""} element={<h1>PlantItUp</h1>}/>
            <Route path={"user"} element={<UserApp/>}/>
        </Routes>
      </BrowserRouter>
        <HeadBar username={username} password={password}/>
        <h1>Manage your plants</h1>
        <UserApp/>
        <h1>PlantAppMock</h1>

    </div>
  );
}

export default App;
