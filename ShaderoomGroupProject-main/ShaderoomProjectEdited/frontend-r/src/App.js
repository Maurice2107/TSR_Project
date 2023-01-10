import './App.css';
import SignIn from "./pages/SignIn";
import {AuthProvider} from "./context/AuthContext";
import {BrowserRouter as Router,Routes, Route} from "react-router-dom";
import PrivateRoute from "./components/PrivateRoute";
import Home from "./pages/Home";
import CategoryMenu from "./pages/CategoryMenu";
import Profile from "./pages/Profile";
import Catergory from "./pages/catergoryname";

function App() {
  return (
      <AuthProvider>

        <Router>
          <Routes>
            <Route path="/home" element={<PrivateRoute><Home /></PrivateRoute>} />
            <Route path="/chat" element={<PrivateRoute><CategoryMenu /></PrivateRoute>} />
            <Route path="/profile" element={<PrivateRoute><Profile /></PrivateRoute>} />
            <Route path="/login" exact element={<SignIn/>}/>
              <Route path="/category/:catergoryname" element={<PrivateRoute><Catergory/></PrivateRoute>} />
          </Routes>
        </Router>

      </AuthProvider>
  );
}

export default App;