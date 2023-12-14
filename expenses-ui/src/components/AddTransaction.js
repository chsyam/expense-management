import React, { useEffect, useState } from "react";
import "./../styles/addTransaction.css";
import axios from "axios";

function AddTransaction() {

    const [users, setUsers] = useState([])
    useEffect(() => {
        const fetchData = async () => {
            try {
                const { data: response } = await axios.get('http://localhost:8080/users/get/all', {
                    headers: {
                        "Content-Type": "application/json"
                    }
                });
                setUsers(response);
            } catch (error) {
                console.error(error.message);
            }
        }
        fetchData();
    }, []);



    const [amount, setAmount] = useState(0);
    const [description, setDescription] = useState("");
    const [checked, setChecked] = useState([]);

    const handleCheck = (event) => {
        var updatedList = [...checked];
        if (event.target.checked) {
            updatedList = [...checked, event.target.value];
        } else {
            updatedList.splice(checked.indexOf(event.target.value), 1);
        }
        setChecked(updatedList);
    };

    const checkedItems = checked.length
        ? checked.reduce((total, item) => {
            return total + ", " + item;
        })
        : "";

    var isChecked = (item) =>
        checked.includes(item) ? "checked-item" : "not-checked-item";

    const handleSubmit = (event) => {
        event.preventDefault();
        if (amount !== 0 && checkedItems.length !== 0 && description.length > 2) {
            const transaction = {
                "amount": amount,
                "description": description,
                "members": checkedItems.split(",")
            }
            console.log(transaction);
        }
    }

    return (
        <div>
            <h1>Add Transaction</h1>
            <form className="form" onSubmit={(event) => handleSubmit(event)}>
                <div className="form-div">
                    <table>
                        <tbody>
                            <tr>
                                <td>Amount</td>
                                <td>
                                    <input type="number" onChange={(event) => setAmount(event.target.value)} placeholder="enter amount" required />
                                </td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td>
                                    <textarea required rows="3" cols="20" type="text" onChange={(event) => setDescription(event.target.value)} placeholder="amount description" />
                                </td>
                            </tr>
                            <tr className="checkList">
                                <td>Members</td>
                                <td className="list-container">
                                    {users.map((item, index) => (
                                        <div key={index}>
                                            <input value={item.id} type="checkbox" onChange={handleCheck} />
                                            <span className={isChecked(item.fullName)}>{item.fullName}</span>
                                        </div>
                                    ))}
                                </td>
                            </tr>
                            <tr className="members">
                                <td colSpan="2" className="checkedItems">
                                    {checkedItems}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div className="buttons">
                        <input type="reset" className="cancel" value="Cancel" />
                        <input type="submit" className="submit" value="Submit" />
                    </div>
                </div>
            </form >
        </div >
    );
}

export default AddTransaction;