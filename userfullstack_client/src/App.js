import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import NavBar from "./layout/NavBar";
import Home from "./pages/Home";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddUser from "./users/AddUser";

function App() {
  return (
    <div className="App">
        <Router>
            <NavBar></NavBar>

            <Routes>
                <Route exact path = "/" element={<Home></Home>}/>
                <Route exact path = "/addUser" element={<AddUser></AddUser>}/>
            </Routes>
        </Router>
    </div>
  );
}

export default App;
