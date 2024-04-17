import React, {useEffect, useState} from "react";
import axios from "axios";

export default  function Home() {
    //creating the object to store user information; the initial state is an empty array
    const [users, setUsers] = useState([])

    //tells react that the component needs to open the user info when it renders
    useEffect(() => {
        loadUsers();
    }, [] //this empty array will make it so that it runs once
    );

    //to load the user info
    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/fullstackUsers/allUsers");
        //getting the data from the database; without the ".data" at the end, the console will return all other config, request, and response, etc.  infos
        setUsers(result.data);
    }

    return (
        <div className="container">
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Username</th>
                        <th scope="col">Email</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        /*
                        Getting the data dynamically from the database; to do that, create a map from users
                        For every user that is retrieved, a table row is created
                         */
                        users.map((user, index) => (
                            <tr>
                                <th scope="row" key={index}>{index + 1}</th>
                                <td>{user.name}</td>
                                <td>{user.userName}</td>
                                <td>{user.email}</td>
                                <td>
                                    <button className="btn btn-primary mx-2">View</button>
                                    <button className="btn btn-outline-primary mx-2">Edit</button>
                                    <button className="btn btn-danger mx-2">Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}