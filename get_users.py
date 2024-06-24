def get_users():
    session = Session()
    result = session.query(users).all()
    session.close()
    return JSONResponse(content={"users": result})

@app.post("/users")
async def create_user(request: Request):
    data = await request.json()
    session = Session()
    new_user = users(name=data["name"], email=data["email"])
    session.add(new_user)
    session.commit()
    session.close()
    return JSONResponse(content={"message": "User created successfully"})

@app.put("/users/{id}")
async def update_user(id: int, request: Request):
    data = await request.json()
    session = Session()
    user = session.query(users).filter_by(id=id).first()
    if not user:
        raise HTTPException(status_code=404, detail="User not found")
    user.name = data["name"]
    user.email = data["email"]
    session.commit()
    session.close()
    return JSONResponse(content={"message": "User updated successfully"})

@app.delete("/users/{id}")
async def delete_user(id: int):
    session = Session()
    user = session.query(users).filter_by(id=id).first()
    if not user:
        raise HTTPException(status_code=404, detail="User not found")
    session.delete(user)
    session.commit()
    session.close()
    return JSONResponse(content={"message": "User deleted successfully"})
```

Explanation:

- We create a SQLAlchemy engine to connect to the database.
- We create a metadata object, a Table object representing the 'users' table in our database, and a Session class for managing database operations.
- We define a FastAPI application and create several endpoints for CRUD operations:
  - **GET /users:** Retrieves all users from the database.
  - **POST /users:** Creates a new user in the database.
  - **PUT /users/{id}:** Updates a user with the specified ID.
  - **DELETE /users/{id}:** Deletes a user with the specified ID.

**React code to build the UI:**

```javascript
import React, { useState, useEffect } from "react";
import axios from "axios";

export default function App() {
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