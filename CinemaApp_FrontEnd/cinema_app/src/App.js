import { formToJSON } from "axios";
import {BrowserRouter, main, Routes,Route} from 'react-router-dom';
import Login from "./login/Login";
import Register from "./register/Register";

function App() {
  return (
    <div className="App">
      {/* <Register /> */}
      <BrowserRouter>
        <Routes>
          <Route path='/' element = {<Register/>} />
          <Route path='register' element = {<Register/>} />
        </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
