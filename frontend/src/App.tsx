import React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import UserApp from "./component/UserApp";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
            <Route path={""} element={<h1>PlantItUp</h1>}/>
            <Route path={"user"} element={<UserApp/>}/>
        </Routes>
      </BrowserRouter>
        <h1>SignUpMock</h1>
        <h1>LoginMock</h1>
        <h1>Manage your plants</h1>
        <UserApp/>
        <h1>PlantAppMock</h1>

    </div>
  );
}

export default App;
