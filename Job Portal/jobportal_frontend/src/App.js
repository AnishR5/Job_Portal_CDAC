import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes,Route,Navigate } from 'react-router-dom';
import HomeComponent from './components/HomeComponent';
import Login from './components/Login';
import Registration from './components/Registration';
import Welcome from './components/JSHome';
import JobList from './components/JobList';
import RegisterJobProvider from './components/RegisterJobProvider';
import PostJob from './components/PostJob';
import LoginJP from './components/LoginJP';
import JPHome from './components/JPHome';
import JSHome from './components/JSHome';
import LoginAdmin from './components/LoginAdmin';
import AdminHome from './components/AdminHome';
import Logout from './components/Logout';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Navigate replace to="/home"></Navigate>}></Route>
        <Route path='/home' element={<HomeComponent/>}></Route>
        
        <Route path='/jobseeker/signin'element={<Login/>}></Route>
        <Route path='/jobseeker/registration' element={<Registration/>}></Route>
        <Route path='/jobseeker/home' element={<JSHome></JSHome>}></Route>
        <Route path='/job/jobs' element={<JobList/>}></Route>
        <Route path='/jobprovider/registration' element={<RegisterJobProvider/>}></Route>
        <Route path='/jobprovider/insertjob' element={<PostJob></PostJob>}></Route>
        <Route path='/jobprovider/home' element={<JPHome></JPHome>}></Route>
        <Route path='/jobprovider/signin'element={<LoginJP/>}></Route>
        <Route path='/admin/signin' element={<LoginAdmin></LoginAdmin>}></Route>
        <Route path='/admin/home' element={<AdminHome></AdminHome>}></Route>
        <Route path='/logout' element={<Logout/>}></Route>
       {/* <Route path='/jobseeker' element={<JobSeekerComponent/>}></Route> */}
      </Routes>
    </div>
  );
}

export default App;
