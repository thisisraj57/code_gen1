def root():
    return {"message": "Hello World"}

@app.post("/create")
async def create():
    data = await request.json()
    user = User(name=data["name"], email=data["email"])
    session.add(user)
    session.commit()
    return {"message": "User created successfully"}

@app.put("/update")
async def update():
    data = await request.json()
    user = session.query(User).get(data["id"])
    user.name = data["name"]
    user.email = data["email"]
    session.commit()
    return {"message": "User updated successfully"}

@app.delete("/delete")
async def delete():
    data = await request.json()
    user = session.query(User).get(data["id"])
    session.delete(user)
    session.commit()
    return {"message": "User deleted successfully"}

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8000)
```

**Explanation:** This FastAPI application allows you to create, update, and delete data from a PostgreSQL database using Java. The UI for this application can be built in React.

**React:**

```javascript
import React, { useState, useEffect } from "react";
import axios from "axios";

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