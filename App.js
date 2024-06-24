function App() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get("/users").then((response) => setUsers(response.data.users));
  }, []);

  const createUser = (data) => {
    axios.post("/users", data).then(() => {
      setUsers([...users, data]);
    });
  };

  const updateUser = (id, data) => {
    axios.put(`/users/${id}`, data).then(() => {
      const updatedUsers = users.map((user) => {
        if (user.id === id) {
          return data;
        }
        return user;
      });
      setUsers(updatedUsers);
    });
  };

  const deleteUser = (id) => {
    axios.delete(`/users/${id}`).then(() => {
      setUsers(users.filter((user) => user.id !== id));
    });
  };

  return (
    <div>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} - {user.email}
            <button onClick={() => updateUser(user.id, { name: "Updated Name", email: "updated.email@example.com" })}>
              Update
            </button>
            <button onClick={() => deleteUser(user.id)}>Delete</button>
          </li>
        ))}
      </ul>
      <button onClick={() => createUser({ name: "New Name", email: "new.email@example.com" })}>Create User</button>
    </div>
  );
}