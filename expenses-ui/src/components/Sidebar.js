import "./../styles/sidebar.css";

function Sidebar(props) {
    return (
        <div className="sidebar">
            <ul>
                <li onClick={() => { props.setAddButton(true); props.setHistoryButton(false); }}>Add Transaction</li>
                <li onClick={() => { props.setHistoryButton(true); props.setAddButton(false); }}>History</li>
            </ul>
        </div >
    );
}

export default Sidebar;