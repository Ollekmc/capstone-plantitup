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
        <h1>Häääää</h1>
        <UserApp/>

    </div>
  );
}

export default App;
