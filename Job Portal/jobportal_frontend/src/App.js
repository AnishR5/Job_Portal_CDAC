import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes,Route,Navigate } from 'react-router-dom';
import HomeComponent from './components/HomeComponent';
import Login from './components/Login';
import Registration from './components/Registration';
import Welcome from './components/Welcome';
import JobList from './components/JobList';
import RegisterJobProvider from './components/RegisterJobProvider';
import PostJob from './components/PostJob';
import LoginJP from './components/LoginJP';
import JPHome from './components/JPHome';


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Navigate replace to="/home"></Navigate>}></Route>
        <Route path='/home' element={<HomeComponent/>}></Route>
        <Route path='/jobprovider/signin'element={<LoginJP/>}></Route>
        <Route path='/jobseeker/signin'element={<Login/>}></Route>
        <Route path='/jobseeker/registration' element={<Registration/>}></Route>
        <Route path='/jobseeker/welcome' element={<Welcome/>}></Route>
        <Route path='/job/jobs' element={<JobList/>}></Route>
        <Route path='/jobprovider/registration' element={<RegisterJobProvider/>}></Route>
        <Route path='/jobprovider/insertjob' element={<PostJob></PostJob>}></Route>
        <Route path='/jobprovider/home' element={<JPHome></JPHome>}></Route>
       {/* <Route path='/jobseeker' element={<JobSeekerComponent/>}></Route> */}
      </Routes>
    </div>
  );
}

export default App;
