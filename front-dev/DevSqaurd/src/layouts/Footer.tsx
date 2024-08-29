import styles from './styles/Footer.module.css';
const Footer = () => {
  return (
    <footer className={styles.footer}>
      <hr />
      <div className={styles.footerContent}>
        <div>
          <p>(주) 데브랩 | 대표 김밥</p>
          <p>서울특별시 종로구 우정국로2길 대왕빌딩 7층</p>
          <p>사업자 등록 번호 : 123-45-67890</p>
        </div>
        <div>
          another
        </div>
      </div>
      <div className={styles.footerBottom}>
        <p>&copy; 2024 Dev.inc. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;
