import { Route, Routes } from "react-router-dom";
import Layout from "../layouts/Layout";
import TestPage from "../pages/TestPage";

export default function Router() {
  return (
    <Routes>
      <Route element={<Layout/>}>
        <Route path="/test" element={<TestPage/>} />  
      </Route>
    </Routes>
  );
};
