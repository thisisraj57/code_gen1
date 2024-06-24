function App() {
  const [users, setUsers] = useState([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    axios.get("/create").then((res) => {
      setUsers(res.data.users);
    });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("/create", { name, email }).then((res) => {
      setUsers([...users, res.data.user]);
    });
  };

  const handleUpdate = (id) => {
    axios.put("/update", { id, name, email }).then((res) => {
      const updatedUser = res.data.user;
      setUsers(users.map((user) => (user.id === updatedUser.id ? updatedUser : user)));
    });
  };

  const handleDelete = (id) => {
    axios.delete("/delete", { id }).then((res) => {
      setUsers(users.filter((user) => user.id !== id));
    });
  };

  return (
    <div>
      <h1>Users</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        <button type="submit">Create</button>
      </form>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} - {user.email}
            <button onClick={() => handleUpdate(user.id)}>Update</button>
            <button onClick={() => handleDelete(user.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}