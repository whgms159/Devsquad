import Carousel from '../components/common/Carousel';
import style from './styles/MainPage.module.css';

const MainPage = () => {
    return (
        <div className={style.container}>
          <div>MainPage</div>
          <Carousel />
        </div>
    );
};

export default MainPage;