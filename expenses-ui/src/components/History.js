import "./../styles/history.css"

function History() {
    const data = [
        {
            "id": 1,
            "totalAmount": 100.00,
            "transactionDate": "2022-01-01",
            "transactionTime": "12:00:00",
            "description": "Sample amount table Sample amount table Sample amount table Sample amount table",
            "membersIncluded": ["syam kumar ch", "yuva teja d", "naga sai b", "ashok d"]
        },
        {
            "id": 2,
            "totalAmount": 100.00,
            "transactionDate": "2022-01-01",
            "transactionTime": "12:00:00",
            "description": "Sample amount table Sample amount table Sample amount table Sample amount table",
            "membersIncluded": ["syam kumar ch", "yuva teja d", "naga sai b", "ashok d"]
        },
        {
            "id": 3,
            "totalAmount": 100.00,
            "transactionDate": "2022-01-01",
            "transactionTime": "12:00:00",
            "description": "Sample amount table Sample amount table Sample amount table Sample amount table",
            "membersIncluded": ["syam kumar ch", "yuva teja d", "naga sai b", "ashok d"]
        },
        {
            "id": 4,
            "totalAmount": 100.00,
            "transactionDate": "2022-01-01",
            "transactionTime": "12:00:00",
            "description": "Sample amount table Sample amount table Sample amount table Sample amount table",
            "membersIncluded": ["syam kumar ch", "yuva teja d", "naga sai b", "ashok d"]
        },
        {
            "id": 5,
            "totalAmount": 100.00,
            "transactionDate": "2022-01-01",
            "transactionTime": "12:00:00",
            "description": "Sample amount table Sample amount table Sample amount table Sample amount table",
            "membersIncluded": ["syam kumar ch", "yuva teja d", "naga sai b", "ashok d"]
        },
        {
            "id": 6,
            "totalAmount": 100.00,
            "transactionDate": "2022-01-01",
            "transactionTime": "12:00:00",
            "description": "Sample amount table Sample amount table Sample amount table Sample amount table",
            "membersIncluded": ["syam kumar ch", "yuva teja d", "naga sai b", "ashok d"]
        }
    ]

    return (
        <div className="history">
            <h1>History</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Amount</th>
                        <th>per head</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Description</th>
                        <th>Members Included</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={index}>
                            <td>{item.id}</td>
                            <td>{item.totalAmount}</td>
                            <td>{item.totalAmount / item.membersIncluded.length}</td>
                            <td>{item.transactionDate}</td>
                            <td>{item.transactionTime}</td>
                            <td>{item.description}</td>
                            <td>
                                {
                                    item.membersIncluded.map((user, index1) => (
                                        <span key={index1}>{user} <br /></span>
                                    ))
                                }
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default History;