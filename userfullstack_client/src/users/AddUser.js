import React, {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

export default function AddUser() {
    //to navigate to the home page
    let navigation = useNavigate();


    //object to store the user information in the state
    const [user, setUser] = useState({
        name: "",
        userName: "",
        email: ""
    });

    //deconstructing the object
    const {name, userName, email} = user;

    //function in charge of updating the object
    const onInputChange = (e) => {
        const name = e.target.getAttribute("name"); //using the tag attribute to specify which field is being changed
        setUser({ ...user, [name]: e.target.value}); //setting the name to the current value in the field
    };

    //function to click submit and post the data to the db
    const onSubmit = async (e) => {
        e.preventDefault(); //prevents the long extra url from showing in the search bar when clicking submit
        //calling the addUser API and saving them to the database
        await axios.post("http://localhost:8080/fullstackUsers/addNewUser", user);
        navigation("/"); //navigating to the home page
    };

    return(
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Add New User</h2>

                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className="mb-3">
                            <label htmlFor="Name" className="form-label">
                                Name
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Your First and Last Name"
                                name="name"
                                value={name}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Username" className="form-label">
                                Username
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Your Username"
                                name="userName"
                                value={userName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Email" className="form-label">
                                Email
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Your Email Address"
                                name="email"
                                value={email}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <button type="submit" className="btn btn-outline-danger mx-2">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    )
}